package org.example.business;

public class HDMIAfficheur implements AgentAfficheur {
    @Override
    public void afficherAgent(Agent agent) {
        System.out.println("HDMI display : " + agent.getNom() + " " + agent.getTransactions());
    }
}
