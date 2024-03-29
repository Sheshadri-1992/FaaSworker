/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package masterthriftservices;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2022-03-09")
public class RegisterFunctionRequest implements org.apache.thrift.TBase<RegisterFunctionRequest, RegisterFunctionRequest._Fields>, java.io.Serializable, Cloneable, Comparable<RegisterFunctionRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RegisterFunctionRequest");

  private static final org.apache.thrift.protocol.TField FUNCTION_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("functionName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FUNCTION_SOURCE_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("functionSourceCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField QOSMETRIC_FIELD_DESC = new org.apache.thrift.protocol.TField("qosmetric", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RegisterFunctionRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RegisterFunctionRequestTupleSchemeFactory();

  public java.lang.String functionName; // required
  public java.lang.String functionSourceCode; // required
  public java.lang.String qosmetric; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FUNCTION_NAME((short)1, "functionName"),
    FUNCTION_SOURCE_CODE((short)2, "functionSourceCode"),
    QOSMETRIC((short)3, "qosmetric");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FUNCTION_NAME
          return FUNCTION_NAME;
        case 2: // FUNCTION_SOURCE_CODE
          return FUNCTION_SOURCE_CODE;
        case 3: // QOSMETRIC
          return QOSMETRIC;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FUNCTION_NAME, new org.apache.thrift.meta_data.FieldMetaData("functionName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FUNCTION_SOURCE_CODE, new org.apache.thrift.meta_data.FieldMetaData("functionSourceCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QOSMETRIC, new org.apache.thrift.meta_data.FieldMetaData("qosmetric", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RegisterFunctionRequest.class, metaDataMap);
  }

  public RegisterFunctionRequest() {
  }

  public RegisterFunctionRequest(
    java.lang.String functionName,
    java.lang.String functionSourceCode,
    java.lang.String qosmetric)
  {
    this();
    this.functionName = functionName;
    this.functionSourceCode = functionSourceCode;
    this.qosmetric = qosmetric;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RegisterFunctionRequest(RegisterFunctionRequest other) {
    if (other.isSetFunctionName()) {
      this.functionName = other.functionName;
    }
    if (other.isSetFunctionSourceCode()) {
      this.functionSourceCode = other.functionSourceCode;
    }
    if (other.isSetQosmetric()) {
      this.qosmetric = other.qosmetric;
    }
  }

  public RegisterFunctionRequest deepCopy() {
    return new RegisterFunctionRequest(this);
  }

  @Override
  public void clear() {
    this.functionName = null;
    this.functionSourceCode = null;
    this.qosmetric = null;
  }

  public java.lang.String getFunctionName() {
    return this.functionName;
  }

  public RegisterFunctionRequest setFunctionName(java.lang.String functionName) {
    this.functionName = functionName;
    return this;
  }

  public void unsetFunctionName() {
    this.functionName = null;
  }

  /** Returns true if field functionName is set (has been assigned a value) and false otherwise */
  public boolean isSetFunctionName() {
    return this.functionName != null;
  }

  public void setFunctionNameIsSet(boolean value) {
    if (!value) {
      this.functionName = null;
    }
  }

  public java.lang.String getFunctionSourceCode() {
    return this.functionSourceCode;
  }

  public RegisterFunctionRequest setFunctionSourceCode(java.lang.String functionSourceCode) {
    this.functionSourceCode = functionSourceCode;
    return this;
  }

  public void unsetFunctionSourceCode() {
    this.functionSourceCode = null;
  }

  /** Returns true if field functionSourceCode is set (has been assigned a value) and false otherwise */
  public boolean isSetFunctionSourceCode() {
    return this.functionSourceCode != null;
  }

  public void setFunctionSourceCodeIsSet(boolean value) {
    if (!value) {
      this.functionSourceCode = null;
    }
  }

  public java.lang.String getQosmetric() {
    return this.qosmetric;
  }

  public RegisterFunctionRequest setQosmetric(java.lang.String qosmetric) {
    this.qosmetric = qosmetric;
    return this;
  }

  public void unsetQosmetric() {
    this.qosmetric = null;
  }

  /** Returns true if field qosmetric is set (has been assigned a value) and false otherwise */
  public boolean isSetQosmetric() {
    return this.qosmetric != null;
  }

  public void setQosmetricIsSet(boolean value) {
    if (!value) {
      this.qosmetric = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case FUNCTION_NAME:
      if (value == null) {
        unsetFunctionName();
      } else {
        setFunctionName((java.lang.String)value);
      }
      break;

    case FUNCTION_SOURCE_CODE:
      if (value == null) {
        unsetFunctionSourceCode();
      } else {
        setFunctionSourceCode((java.lang.String)value);
      }
      break;

    case QOSMETRIC:
      if (value == null) {
        unsetQosmetric();
      } else {
        setQosmetric((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FUNCTION_NAME:
      return getFunctionName();

    case FUNCTION_SOURCE_CODE:
      return getFunctionSourceCode();

    case QOSMETRIC:
      return getQosmetric();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case FUNCTION_NAME:
      return isSetFunctionName();
    case FUNCTION_SOURCE_CODE:
      return isSetFunctionSourceCode();
    case QOSMETRIC:
      return isSetQosmetric();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RegisterFunctionRequest)
      return this.equals((RegisterFunctionRequest)that);
    return false;
  }

  public boolean equals(RegisterFunctionRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_functionName = true && this.isSetFunctionName();
    boolean that_present_functionName = true && that.isSetFunctionName();
    if (this_present_functionName || that_present_functionName) {
      if (!(this_present_functionName && that_present_functionName))
        return false;
      if (!this.functionName.equals(that.functionName))
        return false;
    }

    boolean this_present_functionSourceCode = true && this.isSetFunctionSourceCode();
    boolean that_present_functionSourceCode = true && that.isSetFunctionSourceCode();
    if (this_present_functionSourceCode || that_present_functionSourceCode) {
      if (!(this_present_functionSourceCode && that_present_functionSourceCode))
        return false;
      if (!this.functionSourceCode.equals(that.functionSourceCode))
        return false;
    }

    boolean this_present_qosmetric = true && this.isSetQosmetric();
    boolean that_present_qosmetric = true && that.isSetQosmetric();
    if (this_present_qosmetric || that_present_qosmetric) {
      if (!(this_present_qosmetric && that_present_qosmetric))
        return false;
      if (!this.qosmetric.equals(that.qosmetric))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetFunctionName()) ? 131071 : 524287);
    if (isSetFunctionName())
      hashCode = hashCode * 8191 + functionName.hashCode();

    hashCode = hashCode * 8191 + ((isSetFunctionSourceCode()) ? 131071 : 524287);
    if (isSetFunctionSourceCode())
      hashCode = hashCode * 8191 + functionSourceCode.hashCode();

    hashCode = hashCode * 8191 + ((isSetQosmetric()) ? 131071 : 524287);
    if (isSetQosmetric())
      hashCode = hashCode * 8191 + qosmetric.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RegisterFunctionRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetFunctionName()).compareTo(other.isSetFunctionName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFunctionName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.functionName, other.functionName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFunctionSourceCode()).compareTo(other.isSetFunctionSourceCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFunctionSourceCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.functionSourceCode, other.functionSourceCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetQosmetric()).compareTo(other.isSetQosmetric());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQosmetric()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.qosmetric, other.qosmetric);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RegisterFunctionRequest(");
    boolean first = true;

    sb.append("functionName:");
    if (this.functionName == null) {
      sb.append("null");
    } else {
      sb.append(this.functionName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("functionSourceCode:");
    if (this.functionSourceCode == null) {
      sb.append("null");
    } else {
      sb.append(this.functionSourceCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("qosmetric:");
    if (this.qosmetric == null) {
      sb.append("null");
    } else {
      sb.append(this.qosmetric);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (functionName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'functionName' was not present! Struct: " + toString());
    }
    if (functionSourceCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'functionSourceCode' was not present! Struct: " + toString());
    }
    if (qosmetric == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'qosmetric' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RegisterFunctionRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RegisterFunctionRequestStandardScheme getScheme() {
      return new RegisterFunctionRequestStandardScheme();
    }
  }

  private static class RegisterFunctionRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<RegisterFunctionRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RegisterFunctionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FUNCTION_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.functionName = iprot.readString();
              struct.setFunctionNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FUNCTION_SOURCE_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.functionSourceCode = iprot.readString();
              struct.setFunctionSourceCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // QOSMETRIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.qosmetric = iprot.readString();
              struct.setQosmetricIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RegisterFunctionRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.functionName != null) {
        oprot.writeFieldBegin(FUNCTION_NAME_FIELD_DESC);
        oprot.writeString(struct.functionName);
        oprot.writeFieldEnd();
      }
      if (struct.functionSourceCode != null) {
        oprot.writeFieldBegin(FUNCTION_SOURCE_CODE_FIELD_DESC);
        oprot.writeString(struct.functionSourceCode);
        oprot.writeFieldEnd();
      }
      if (struct.qosmetric != null) {
        oprot.writeFieldBegin(QOSMETRIC_FIELD_DESC);
        oprot.writeString(struct.qosmetric);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RegisterFunctionRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RegisterFunctionRequestTupleScheme getScheme() {
      return new RegisterFunctionRequestTupleScheme();
    }
  }

  private static class RegisterFunctionRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<RegisterFunctionRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RegisterFunctionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.functionName);
      oprot.writeString(struct.functionSourceCode);
      oprot.writeString(struct.qosmetric);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RegisterFunctionRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.functionName = iprot.readString();
      struct.setFunctionNameIsSet(true);
      struct.functionSourceCode = iprot.readString();
      struct.setFunctionSourceCodeIsSet(true);
      struct.qosmetric = iprot.readString();
      struct.setQosmetricIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

