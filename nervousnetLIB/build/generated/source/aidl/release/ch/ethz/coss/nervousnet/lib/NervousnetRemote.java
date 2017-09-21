/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/jubatyrn/Documents/nervousnet-android/MobileClients/Android/nervousnet/nervousnetLIB/src/main/aidl/ch/ethz/coss/nervousnet/lib/NervousnetRemote.aidl
 */
package ch.ethz.coss.nervousnet.lib;
public interface NervousnetRemote extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements ch.ethz.coss.nervousnet.lib.NervousnetRemote
{
private static final java.lang.String DESCRIPTOR = "ch.ethz.coss.nervousnet.lib.NervousnetRemote";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an ch.ethz.coss.nervousnet.lib.NervousnetRemote interface,
 * generating a proxy if needed.
 */
public static ch.ethz.coss.nervousnet.lib.NervousnetRemote asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof ch.ethz.coss.nervousnet.lib.NervousnetRemote))) {
return ((ch.ethz.coss.nervousnet.lib.NervousnetRemote)iin);
}
return new ch.ethz.coss.nervousnet.lib.NervousnetRemote.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getNervousnetHubStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getNervousnetHubStatus();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLatestReading:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
ch.ethz.coss.nervousnet.lib.SensorReading _result = this.getLatestReading(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getReading:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
ch.ethz.coss.nervousnet.lib.RemoteCallback _arg1;
_arg1 = ch.ethz.coss.nervousnet.lib.RemoteCallback.Stub.asInterface(data.readStrongBinder());
this.getReading(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getReadings:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
long _arg1;
_arg1 = data.readLong();
long _arg2;
_arg2 = data.readLong();
ch.ethz.coss.nervousnet.lib.RemoteCallback _arg3;
_arg3 = ch.ethz.coss.nervousnet.lib.RemoteCallback.Stub.asInterface(data.readStrongBinder());
this.getReadings(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_writeReading:
{
data.enforceInterface(DESCRIPTOR);
ch.ethz.coss.nervousnet.lib.SensorReading _arg0;
if ((0!=data.readInt())) {
_arg0 = ch.ethz.coss.nervousnet.lib.SensorReading.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
ch.ethz.coss.nervousnet.lib.InfoReading _result = this.writeReading(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements ch.ethz.coss.nervousnet.lib.NervousnetRemote
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/*
           	 	* Returns the current state of Nervousnet HUB - RUNNING or PAUSED
           	    * returns boolean
           	    */
@Override public boolean getNervousnetHubStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNervousnetHubStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/*
       	 	* Returns latest Sensor values.
       	    * sensorType = type of Sensor. Check LibConstants.java for types.
       	    * returns SensorReading object
       	    */
@Override public ch.ethz.coss.nervousnet.lib.SensorReading getLatestReading(long sensorType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
ch.ethz.coss.nervousnet.lib.SensorReading _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(sensorType);
mRemote.transact(Stub.TRANSACTION_getLatestReading, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = ch.ethz.coss.nervousnet.lib.SensorReading.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/*
	 	* Returns latest Sensor value (single reading) using callback
	    * sensorType = type of Sensor. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain a single returned object of SensorReading
	    */
@Override public void getReading(long sensorType, ch.ethz.coss.nervousnet.lib.RemoteCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(sensorType);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getReading, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*
	 	* Returns Sensor values in a List of SensorReading Objects using callback
	    * sensorType = type of Sensors. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain the returned objects of SensorReadings
	    */
@Override public void getReadings(long sensorType, long startTime, long endTime, ch.ethz.coss.nervousnet.lib.RemoteCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(sensorType);
_data.writeLong(startTime);
_data.writeLong(endTime);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getReadings, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public ch.ethz.coss.nervousnet.lib.InfoReading writeReading(ch.ethz.coss.nervousnet.lib.SensorReading reading) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
ch.ethz.coss.nervousnet.lib.InfoReading _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((reading!=null)) {
_data.writeInt(1);
reading.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_writeReading, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = ch.ethz.coss.nervousnet.lib.InfoReading.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getNervousnetHubStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getLatestReading = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getReading = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getReadings = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_writeReading = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
/*
           	 	* Returns the current state of Nervousnet HUB - RUNNING or PAUSED
           	    * returns boolean
           	    */
public boolean getNervousnetHubStatus() throws android.os.RemoteException;
/*
       	 	* Returns latest Sensor values.
       	    * sensorType = type of Sensor. Check LibConstants.java for types.
       	    * returns SensorReading object
       	    */
public ch.ethz.coss.nervousnet.lib.SensorReading getLatestReading(long sensorType) throws android.os.RemoteException;
/*
	 	* Returns latest Sensor value (single reading) using callback
	    * sensorType = type of Sensor. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain a single returned object of SensorReading
	    */
public void getReading(long sensorType, ch.ethz.coss.nervousnet.lib.RemoteCallback cb) throws android.os.RemoteException;
/*
	 	* Returns Sensor values in a List of SensorReading Objects using callback
	    * sensorType = type of Sensors. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain the returned objects of SensorReadings
	    */
public void getReadings(long sensorType, long startTime, long endTime, ch.ethz.coss.nervousnet.lib.RemoteCallback cb) throws android.os.RemoteException;
public ch.ethz.coss.nervousnet.lib.InfoReading writeReading(ch.ethz.coss.nervousnet.lib.SensorReading reading) throws android.os.RemoteException;
}
