package stepsdefinitions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.example.pageObject.Constantes;
import org.example.questions.StatusGET;
import org.example.tasks.SongsGET;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StepsGetSongs {

    @Dado("Daniel es un usuario con los permisos para consultar los recursos")
    public void daniel_es_un_usuario_con_los_permisos_para_consultar_los_recursos() {

    }

    @Cuando("Daniel consume el metodo GET {string} {string}")
    public void danielConsumeElMetodoGet(String id, String l) {
        Actor qa= Actor.named("qa")
                .whoCan(CallAnApi.at(Constantes.URL_BASE));

        qa.attemptsTo(
                SongsGET.consultarSong(id,l)
        );
    }


    @Entonces("Daniel visualiza respuesta exitosa")
    public void danielVisualizaRespuestaExitosa() {
        Actor qa= Actor.named("qa");
        qa.should(
                seeThat(new StatusGET(), equalTo(HttpStatus.SC_OK))
        );
    }


}
