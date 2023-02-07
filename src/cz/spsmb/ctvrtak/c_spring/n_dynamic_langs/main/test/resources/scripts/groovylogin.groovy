import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service.Login

/**
 * @author Felipe Gutierrez
 *
 */
class GroovyLoginService implements Login {

    String username
    String password

    boolean isAuthorized(String email, String pass) {
        if(username==email && password==pass)
            return true
        return false
    }

}