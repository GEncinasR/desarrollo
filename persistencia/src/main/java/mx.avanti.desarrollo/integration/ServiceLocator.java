package mx.avanti.desarrollo.integration;

import jakarta.persistence.EntityManager;
import mx.avanti.desarrollo.dao.AlumnoDAO;
import mx.avanti.desarrollo.dao.UsuarioDAO;
import mx.avanti.desarrollo.persistence.HibernateUtil;

/**
 *
 * @author total
 */
public class ServiceLocator {

  private static AlumnoDAO alumnoDAO;
  private static UsuarioDAO usuarioDAO;

  private static EntityManager getEntityManager() {
    return HibernateUtil.getEntityManager();
  }

  /**
   * se crea la instancia para alumno DAO si esta no existe
   */
  public static AlumnoDAO getInstanceAlumnoDAO() {
    if (alumnoDAO == null) {
      alumnoDAO = new AlumnoDAO(getEntityManager());
      return alumnoDAO;
    } else {
      return alumnoDAO;
    }
  }

  /**
   * se crea la instancia de usuarioDAO si esta no existe
   */
  public static UsuarioDAO getInstanceUsuarioDAO() {
    if (usuarioDAO == null) {
      usuarioDAO = new UsuarioDAO(getEntityManager());
      return usuarioDAO;
    } else {
      return usuarioDAO;
    }
  }

}
