package ggn.lecture.verb.Features.Internal.Base;

/**
 * Created by G-Expo on 25 Jan 2017.
 */
//abstract public class CurrentLocFragment extends Fragment implements
//        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
//{
//
//    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 60000;
//    private GoogleApiClient mGoogleApiClient;
//    private LocationRequest mLocationRequest;
//    // Location updates intervals in sec
//    private static int UPDATE_INTERVAL = 30000; // 30 sec
//    private static int FATEST_INTERVAL = 5000; // 5 sec
//    private static int DISPLACEMENT    = 50; // 50 meters
//    public static Location mLastLocation;
//
//    public SharedPrefHelper sharedPrefHelper;
//
//    public abstract void getCurrentLocationG(Location currentLocation);
//
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        if (checkPlayServices()) {
//            // Building the GoogleApi client
//            buildGoogleApiClient();
//            createLocationRequest();
//        }
//        sharedPrefHelper = new SharedPrefHelper(getActivity());
//        super.onCreate(savedInstanceState);
//    }
//
//    public SharedPrefHelper getLocaldata()
//    {
//        if (sharedPrefHelper == null) {
//            sharedPrefHelper = new SharedPrefHelper(getActivity());
//        }
//
//        return sharedPrefHelper;
//    }
//
//    @Override
//    public void onStart()
//    {
//        super.onStart();
//        if (mGoogleApiClient != null) {
//            mGoogleApiClient.connect();
//        }
//    }
//
//    @Override
//    public void onStop()
//    {
//        super.onStop();
//        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
//            mGoogleApiClient.disconnect();
//        }
//    }
//
//    public synchronized void buildGoogleApiClient()
//    {
//        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API).build();
//
//    }
//
//    /**
//     * Creating currentCenterLocation request object
//     */
//    public void createLocationRequest()
//    {
//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//    }
//
//    /**
//     * Method to verify google play services on the device
//     */
//    public boolean checkPlayServices()
//    {
//        int resultCode = GooglePlayServicesUtil
//                .isGooglePlayServicesAvailable(getActivity());
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
//                GooglePlayServicesUtil.getErrorDialog(resultCode, (Activity)
//                        getActivity(), PLAY_SERVICES_RESOLUTION_REQUEST).show();
//            }
//            else {
//
//                (getActivity()).finish();
//            }
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Method to display the currentCenterLocation on main UI
//     */
//    public Location displayLocation()
//    {
//        try {
//            if (mLastLocation != null) {
//                getCurrentLocationG(mLastLocation);
//                return mLastLocation;
//            }
//            mLastLocation = LocationServices.FusedLocationApi.
//                    getLastLocation(mGoogleApiClient);
//
//            if (mLastLocation != null) {
//                getCurrentLocationG(mLastLocation);
//                return mLastLocation;
//            }
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        getCurrentLocationG(null);
//
//        return null;
//    }
//
//    LocationListener locationListener = new LocationListener()
//    {
//        @Override
//        public void onLocationChanged(Location location)
//        {
//            mLastLocation = location;
//
//            displayLocation();
//        }
//    };
//
//    @Override
//    public void onConnected(Bundle bundle)
//    {
////        displayLocation();
//
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, locationListener);
//        displayLocation();
//    }
//
//    public void stopLocationUpdates()
//    {
//        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, locationListener);
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i)
//    {
//        //handler connection suspended here..
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult)
//    {
//        //handler connection failed here..
//    }
//}