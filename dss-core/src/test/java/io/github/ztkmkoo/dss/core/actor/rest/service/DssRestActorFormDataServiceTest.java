package io.github.ztkmkoo.dss.core.actor.rest.service;

import io.github.ztkmkoo.dss.core.actor.rest.entity.DssRestServiceRequest;
import io.github.ztkmkoo.dss.core.actor.rest.entity.DssRestServiceResponse;
import io.github.ztkmkoo.dss.core.network.rest.enumeration.DssRestMethodType;
import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Project: dss
 * Created by: @ztkmkoo(ztkmkoo@gmail.com)
 * Date: 20. 4. 6. 오전 1:16
 */
public class DssRestActorFormDataServiceTest {

    @Test
    public void getBody() {

        final DssRestActorFormDataService service = new DssRestActorFormDataService("test", "/test", DssRestMethodType.GET) {
            @Override
            protected DssRestServiceResponse handlingRequest(DssRestServiceRequest<HashMap<String, Serializable>> request) {
                return null;
            }
        };

        final HashMap<String, Serializable> map1 = service.getBody("");
        assertTrue(map1.isEmpty());

        final HashMap<String, Serializable> map2 = service.getBody("id=kebron&password=1234567");
        assertFalse(map2.isEmpty());
        assertEquals("kebron", map2.get("id"));
        assertEquals("1234567", map2.get("password"));
    }
}