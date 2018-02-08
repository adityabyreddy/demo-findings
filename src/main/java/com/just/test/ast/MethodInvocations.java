package com.just.test.ast;

/**
 * 
 * @author jdelgrosso
 * 
 * ANY changes here should also be made to the equivalent test file used
 * in the .NET test project.
 *
 */
public class MethodInvocations {
	public String publicString;
	protected String protectedString;
	private String privateString;
	private int privateInt;

	public String getPrivateString() {
		return privateString;
	}
	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
	public int getPrivateInt() {
		return privateInt;
	}
	
	
	public void miPublicVoid()	{
		publicString = "";
		protectedString = "";
		privateString = "";
	}
	protected void miProtectedVoid()	{
	}
	private void miPrivateVoid()	{
	}
	
	
	public int miPublicReturnLiteralInt() {
		return 0;
	}
	public String miPublicReturnLiteralString() {
		return "method miPublicReturnLiteral";
	}
	public String miPublicReturnMemberVariable() {
		return privateString;
	}
	public String miPublicReturnInfix() {
		return privateString + protectedString + publicString;
	}
	public String miPublicReturnMethodInvocation() {
		return getPrivateString();
	}
	public String miPublicReturnParameter(String strParam) {
		return strParam;
	}
	
	
	public void miPublicVoidCallAll() {
		String localTemp;
		int localInt;
		
		miPublicVoid();
		miProtectedVoid();
		miPrivateVoid();
		
		localInt = miPublicReturnLiteralInt();
		localTemp = miPublicReturnLiteralString();
		localTemp = miPublicReturnMemberVariable();
		localTemp = this.miPublicReturnInfix();
		localTemp = this.miPublicReturnMethodInvocation();
		localTemp = this.miPublicReturnParameter("");
	}
	
	
	private void miPrivateVoidParams(int someInt, String someString) {
		privateString = someString;
		privateInt = someInt;
	}
	public void miPrivateVoidMethodInvocations(int someInt, String someString) {
		miPrivateVoidParams(0, "");
		miPrivateVoidParams(someInt, someString);
		miPrivateVoidParams(this.privateInt, this.protectedString);
		miPrivateVoidParams(getPrivateInt(), getPrivateString());
		miPrivateVoidParams(someInt + privateInt + 1, someString + privateString + "!");
		miPrivateVoidParams(someInt + miPublicReturnLiteralInt(), someString + miPublicReturnLiteralString());
	}
	
	
	static private void miStaticPrivateVoid()	{
	}
	static protected void miStaticProtectedVoid()	{
		miStaticPrivateVoid();
	}
	static public void miStaticPublicVoid()	{
		miStaticProtectedVoid();
	}
}
