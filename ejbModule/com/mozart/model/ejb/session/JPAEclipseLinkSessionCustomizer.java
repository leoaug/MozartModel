package com.mozart.model.ejb.session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
 
import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.server.ServerSession;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;
 
/**
 * See
 * http://wiki.eclipse.org/Customizing_the_EclipseLink_Application_(ELUG)
 * Use for clients that would like to use a JTA SE pu instead of a RESOURCE_LOCAL SE pu.
 */
public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer {
  public static final String JNDI_DATASOURCE_NAME = "java:/XAMOZARTDS";
  /**
   * Get a dataSource connection and set it on the session with lookupType=STRING_LOOKUP
   */
  public void customize(Session session) throws Exception {
    JNDIConnector connector = null;
    // Initialize session customizer
    DataSource dataSource = null;
      try {
        Context context = new InitialContext();
        if (null == context) {
          throw new Exception("Context is null");
        }
        // Create a new org.jboss.resource.adapter.jdbc.WrapperDataSource
        //connector = new JNDIConnector(context, JNDI_DATASOURCE_NAME);
        connector = (JNDIConnector)session.getLogin().getConnector(); // possible CCE
        // Lookup this new dataSource
        dataSource = (DataSource) context.lookup(JNDI_DATASOURCE_NAME);
      } catch (Exception e) {
        e.printStackTrace();
      }
    connector.setDataSource(dataSource);
    // Change from COMPOSITE_NAME_LOOKUP to STRING_LOOKUP
    // Note: if both jta and non-jta elements exist this will only change the first one - and may still result in the COMPOSITE_NAME_LOOKUP being set
    // Make sure only jta-data-source is in persistence.xml with no non-jta-data-source property set
    connector.setLookupType(JNDIConnector.STRING_LOOKUP);
 
    // if you are specifying both JTA and non-JTA in your persistence.xml then set both connectors to be safe
    JNDIConnector writeConnector = (JNDIConnector) session.getLogin().getConnector();
    writeConnector.setLookupType(JNDIConnector.STRING_LOOKUP);
    JNDIConnector readConnector = (JNDIConnector) ((DatabaseLogin)((ServerSession)session).getReadConnectionPool().getLogin()).getConnector();
    readConnector.setLookupType(JNDIConnector.STRING_LOOKUP);
 
    // Set the new connection on the session
    session.getLogin().setConnector(connector);
  }
}