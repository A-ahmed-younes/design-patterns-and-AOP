package org.example.business;

public class VGAAfficheur implements AgentAfficheur {
    @Override
    public void afficherAgent(Agent agent) {
        System.out.println("VGA display : " + agent.getNom() + " " + agent.getTransactions());
    }
}
