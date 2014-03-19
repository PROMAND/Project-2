package pl.byd.wsg.promand.project1.dao.columns;

public enum TrackColumn {
    ID,
    TITLE;

    public static String[] getColumnNames() {
        String[] names = new String[values().length];
        for(int index = 0; index < names.length; index++){
            names[index] = values()[index].toString();
        }
        return names;
    }
}
