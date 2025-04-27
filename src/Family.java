import java.util.*;

public class Family {
    Map<String, List<Person>> familyMembers = new HashMap<>();

    public void add(Person... persons){ // te 3 kropki to lista ~ wariadyczna ~
        for(Person person : persons) {
            String key = person.name();
            if(familyMembers.containsKey(key)){
                List<Person> existingFamilyMembers = familyMembers.get(key);
                if(!existingFamilyMembers.contains(person)){
                    existingFamilyMembers.add(person);
                }
            } else{
                List<Person> newFamilyMembers = new ArrayList<>();
                newFamilyMembers.add(person);
                familyMembers.put(key, newFamilyMembers);
            }
        }
    }

    public Person[] get(String key){
        List<Person> familyMembersWithSameName = familyMembers.get(key);
        if(familyMembersWithSameName == null) return new Person[0];
        Person[] result = familyMembersWithSameName.toArray(new Person[0]);
        Arrays.sort(result); //sortowanie arraya
        return result;
    }
}