package Chapter3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import utils.DateUtils;

public class PetQueue
{
    private class Pet
    {
        private Date enterDate;
        private Date birthDate;

        public Pet(Date enterDate, Date birthDate)
        {
            this.enterDate = enterDate;
            this.birthDate = birthDate;
        }

        public Date getEnterDate()
        {
            return enterDate;
        }

        public Date getBirthDate()
        {
            return birthDate;
        }
    }

    private class Cat extends Pet
    {

        public Cat(Date enterDate, Date birthDate)
        {
            super(enterDate, birthDate);
        }
    }

    private class Dog extends Pet
    {
        public Dog(Date enterDate, Date birthDate)
        {
            super(enterDate, birthDate);
        }
    }

    private static List<Pet> petList;

    public PetQueue()
    {
        this.petList = new LinkedList<Pet>();
    }

    public List<Pet> getPetList()
    {
        return petList;
    }

    public void enqueuePet(Pet pet)
    {
        petList.add(pet);

        Collections.sort(petList, new Comparator<Pet>()
        {

            @Override
            public int compare(Pet o1, Pet o2)
            {
                return o1.getEnterDate().compareTo(o2.getEnterDate());
            }
        });
    }

    public static Pet dequeuePet()
    {
        if (!petList.isEmpty())
        {
            return petList.remove(0);
        }
        return null;
    }

    public static Dog dequeueDog()
    {
        Dog dog = null;
        List<Pet> dogList = new ArrayList<Pet>();
        for (Pet pet : petList)
        {
            if (pet instanceof Dog)
            {
                dogList.add(pet);
            }
        }

        Collections.sort(petList, new Comparator<Pet>()
        {
            @Override
            public int compare(Pet o1, Pet o2)
            {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });

        dog = (Dog) dogList.get(0);
        petList.remove(dog);
        return dog;
    }

    public static Cat dequeueCat()
    {
        Cat cat = null;
        List<Pet> catList = new ArrayList<Pet>();
        for (Pet pet : petList)
        {
            if (pet instanceof Cat)
            {
                catList.add(pet);
            }
        }
        Collections.sort(catList, new Comparator<Pet>()
        {
            @Override
            public int compare(Pet o1, Pet o2)
            {
                return o2.getBirthDate().compareTo(o1.getBirthDate());
            }
        });

        cat = (Cat) catList.get(0);
        petList.remove(cat);
        return cat;
    }

    public static void main(String[] args)
    {
        PetQueue queue = new PetQueue();
        queue.enqueuePet(queue.new Dog(DateUtils.createDate(2019, 9, 12, 12, 5),
                DateUtils.createDate(2012, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Cat(DateUtils.createDate(2019, 9, 10, 12, 5),
                DateUtils.createDate(2013, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Dog(DateUtils.createDate(2019, 9, 12, 10, 5),
                DateUtils.createDate(2014, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Cat(DateUtils.createDate(2019, 9, 12, 9, 5),
                DateUtils.createDate(2014, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Cat(DateUtils.createDate(2019, 9, 17, 12, 5),
                DateUtils.createDate(2015, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Cat(DateUtils.createDate(2019, 9, 12, 1, 5),
                DateUtils.createDate(2015, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Dog(DateUtils.createDate(2019, 9, 8, 12, 5),
                DateUtils.createDate(2011, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Cat(DateUtils.createDate(2019, 9, 12, 4, 5),
                DateUtils.createDate(2013, 2, 3, 12, 12)));
        queue.enqueuePet(queue.new Dog(DateUtils.createDate(2019, 9, 12, 12, 5),
                DateUtils.createDate(2015, 2, 3, 12, 12)));

        System.out.println("queue size before dequeue: " + queue.getPetList().size());
        Pet pet = PetQueue.dequeuePet();
        System.out.println(pet.getBirthDate().toString() + "  " + pet.getEnterDate().toString());

        System.out.println("queue size after first dequeue: " + queue.getPetList().size());
        Cat cat = PetQueue.dequeueCat();
        System.out.println(cat.getBirthDate().toString() + "  " + cat.getEnterDate().toString());

        System.out.println("queue size after second dequeue: " + queue.getPetList().size());
        Dog dog = PetQueue.dequeueDog();
        System.out.println(dog.getBirthDate().toString() + "  " + dog.getEnterDate().toString());
    }
}
