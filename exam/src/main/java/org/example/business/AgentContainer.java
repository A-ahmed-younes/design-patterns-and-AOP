package org.example.business;

import java.util.HashMap;

public class AgentContainer {
    private HashMap<String, Agent> agents;

    private static AgentContainer containerSingleton;
    private AgentAfficheur afficheur;

    public static AgentContainer getInstance() {
        if (containerSingleton == null) {
            containerSingleton = new AgentContainer();
        }
        return containerSingleton;
    }
    public AgentContainer() {
        this.agents = new HashMap<>();
    }

    public void ajouterAgent(Agent agent) {
        this.agents.put(agent.getNom(), agent);
    }

    public void supprimerAgent(Agent agent) {
        this.agents.remove(agent.getNom());
    }

    public Agent rechercherAgent(String nomAgent) {
        return this.agents.get(nomAgent);
    }

    public void afficherAgents() {
        for (Agent agent : this.agents.values()) {
            this.afficheur.afficherAgent(agent);
        }
    }

    public void setAfficheur(AgentAfficheur afficheur) {
        this.afficheur = afficheur;
    }
}
