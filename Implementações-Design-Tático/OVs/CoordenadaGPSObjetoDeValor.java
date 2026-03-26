package OVs;
public record CoordenadaGPSObjetoDeValor (double latitude, double longitude)  {
    public CoordenadaGPSObjetoDeValor {
        if(latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude deve estar entre -90 e +90");
        }
        if(longitude < 0 || longitude > 180) {
            throw new IllegalArgumentException("Longitude deve estar entre 0 e 180");
        }
    }

    public double distanceTo(CoordenadaGPSObjetoDeValor outra) {
        final double RAIO_TERRA_KM = 6371.0;

        double lat1Rad = Math.toRadians(this.latitude);
        double lon1Rad = Math.toRadians(this.longitude);
        double lat2Rad = Math.toRadians(outra.latitude);
        double lon2Rad = Math.toRadians(outra.longitude);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TERRA_KM * c;
    }
}
