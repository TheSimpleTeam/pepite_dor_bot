package fr.noalegeek.pepite_dor_bot;

public class Infos {

    public final String token, prefix, defaultRoleID;
    public final String[] activities;
    public final long timeBetweenStatusChange;

    public Infos(String token, String prefix, String defaultRoleID, String[] activities, int timeBetweenStatusChange) {
        this.token = token;
        this.prefix = prefix;
        this.defaultRoleID = defaultRoleID;
        this.activities = activities;
        this.timeBetweenStatusChange = timeBetweenStatusChange;
    }
}
