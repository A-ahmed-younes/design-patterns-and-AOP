package org.example;

import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        Map<String, Strategy> strategyMap = new HashMap<>();
        Strategy strategy;
        while (true) {
            System.out.println("Quelle stratégie? : ");
            String str = scanner.nextLine();
            strategy = strategyMap.get(str);
            if (strategy == null) {
                System.out.println("Création d'un nouvel objet de StrategyImpl" + str);
                strategy = (Strategy) Class.forName(str).getConstructor().newInstance();
                strategyMap.put(str,strategy);

            }
            context.setStrategy(strategy);
            context.effectuerOperation();
       }

    }

}

