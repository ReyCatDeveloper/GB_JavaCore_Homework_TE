package lesson1;

import static lesson1.Barrier.groundBarrier;
import static lesson1.Barrier.waterBarrier;

public class Main {
    public static void main(String[] args) {
        //НАША КОМАНДА
        Team warriors = new Team("Warriors", new Member[]{
                new Member("WarriorLead","Captain",24,10000,500),
                new Member("Warrior1","lastName1","secondName1",23,9000,200),
                new Member("Warrior2","lastName2","secondName2",22,8000,300),
                new Member("Warrior3","lastName3",21,6500,450)
        });

        //ПОКАЗАТЬ НАШУ КОМАНДУ
        warriors.getTeamMembersInfo();

        //ПОЛОСА ПРЕПЯТСТВИЙ
        Course wayOfWarrior = new Course("The Way of Warrior", new Barrier[]{groundBarrier, waterBarrier });

        //КОМАНДА ПРОХОДИТ ЧЕРЕЗ ПОЛОСУ ПРЕПЯТСТВИЙ //TODO чуть переделать финалистов. финалисты в самой полосе препятствий
        int[] theFinalists = wayOfWarrior.tryTheBarrier(warriors);

        //ПОКАЗАТЬ ИНФОРМАЦИЮ о ПОБЕДИТЕЛЯХ
        warriors.getFinalistMemberInfo(theFinalists);
    }
}