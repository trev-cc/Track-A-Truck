package edu.wtamu.tfleeman.track_a_truck.database;

/**
 * Created by trevorfleeman on 4/2/18.
 */

public class TruckSchema {
    public static final class TruckTable{
        public static final String NAME = "Truck";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String Make = "Make";
            public static final String Model = "lnamne";
            public static final String Year = "lat";
            public static final String Color = "lon";

        }
    }
}

