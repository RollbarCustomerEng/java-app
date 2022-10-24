package rb.java;


import com.rollbar.notifier.provider.Provider;
import com.rollbar.api.payload.data.Person;

class PersonProvider implements Provider<Person> {

    @Override
    public Person provide() {

        //
        // Return a Person object that represents the currently logged in user. 
        // If your application does not have the concept of a user, you can use the Person 
        // object to stort other meaningful information. For example:
        // the Customer ID, the Customer Name etc.
        // Person.id is the only required field
        //
        // See also: 
        // https://docs.rollbar.com/docs/person-tracking
        //
    
        return new Person.Builder()
            .id(String.valueOf(("123")))
            .username("Jane Smith")
            .build();
    }
}