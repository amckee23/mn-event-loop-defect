package event.loop.issue;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

import static io.micronaut.http.HttpResponse.ok;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Slf4j
@Controller(value = "/loop")
public class EventLoopClient {

    @Post(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.IO)
    public Single<HttpResponse<String>> post(Model model) {
        log.info("Just printing my thread....{}", model.getTest());
        return Single.just(ok("Return - Post"));
    }

    @Get(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.IO)
    public Single<HttpResponse<String>> get() {
        log.info("Just printing my thread....");
        return Single.just(ok("Return - Get"));
    }

    @Put(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.IO)
    public Single<HttpResponse<String>> put() {
        log.info("Just printing my thread....");
        return Single.just(ok("Return - Put"));
    }

    @Delete(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.IO)
    public Single<HttpResponse<String>> delete() {
        log.info("Just printing my thread....");
        return Single.just(ok("Return - Delete"));
    }

}
