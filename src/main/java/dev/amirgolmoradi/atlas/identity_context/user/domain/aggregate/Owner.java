package dev.amirgolmoradi.atlas.identity_context.user.domain.aggregate;

import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;

public class Owner {
    private final Id id;

    public Owner(Id id) {
        this.id = id;
    }


    //TODO: OWNER CAN DELETE AND RE-ASSIGN A NEW MANAGER FOR THE BUILDING

   //TODO: OWNER CAN SET A NAME FOR THE BUILDING ONLY ONCE

  // TODO: OWNER CAN  DEFINE A LEASE FOR EACH APARTMENT WITH TENANT

}
