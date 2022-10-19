package rb.java;


import com.rollbar.notifier.provider.Provider;
import com.rollbar.api.payload.data.Person;

class PersonProvider implements Provider<Person> {

    @Override
    public Person provide() {

        // set this to an id that will be meaningful for your application. Only id is a rquired property
        return new Person.Builder()
            .id(String.valueOf(("123")))
            .username("Abc Inc")
            .build();
    }
}