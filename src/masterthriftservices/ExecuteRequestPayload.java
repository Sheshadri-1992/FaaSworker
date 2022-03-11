/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package masterthriftservices;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2022-03-09")
public class ExecuteRequestPayload implements org.apache.thrift.TBase<ExecuteRequestPayload, ExecuteRequestPayload._Fields>, java.io.Serializable, Cloneable, Comparable<ExecuteRequestPayload> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExecuteRequestPayload");

  private static final org.apache.thrift.protocol.TField EVENT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("eventName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PAYLOAD_FIELD_DESC = new org.apache.thrift.protocol.TField("payload", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField INPUTSIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("inputsize", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ExecuteRequestPayloadStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ExecuteRequestPayloadTupleSchemeFactory();

  public java.lang.String eventName; // required
  public java.nio.ByteBuffer payload; // required
  public int inputsize; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENT_NAME((short)1, "eventName"),
    PAYLOAD((short)2, "payload"),
    INPUTSIZE((short)3, "inputsize");

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
        case 1: // EVENT_NAME
          return EVENT_NAME;
        case 2: // PAYLOAD
          return PAYLOAD;
        case 3: // INPUTSIZE
          return INPUTSIZE;
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
  private static final int __INPUTSIZE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT_NAME, new org.apache.thrift.meta_data.FieldMetaData("eventName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PAYLOAD, new org.apache.thrift.meta_data.FieldMetaData("payload", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.INPUTSIZE, new org.apache.thrift.meta_data.FieldMetaData("inputsize", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExecuteRequestPayload.class, metaDataMap);
  }

  public ExecuteRequestPayload() {
  }

  public ExecuteRequestPayload(
    java.lang.String eventName,
    java.nio.ByteBuffer payload,
    int inputsize)
  {
    this();
    this.eventName = eventName;
    this.payload = org.apache.thrift.TBaseHelper.copyBinary(payload);
    this.inputsize = inputsize;
    setInputsizeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecuteRequestPayload(ExecuteRequestPayload other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetEventName()) {
      this.eventName = other.eventName;
    }
    if (other.isSetPayload()) {
      this.payload = org.apache.thrift.TBaseHelper.copyBinary(other.payload);
    }
    this.inputsize = other.inputsize;
  }

  public ExecuteRequestPayload deepCopy() {
    return new ExecuteRequestPayload(this);
  }

  @Override
  public void clear() {
    this.eventName = null;
    this.payload = null;
    setInputsizeIsSet(false);
    this.inputsize = 0;
  }

  public java.lang.String getEventName() {
    return this.eventName;
  }

  public ExecuteRequestPayload setEventName(java.lang.String eventName) {
    this.eventName = eventName;
    return this;
  }

  public void unsetEventName() {
    this.eventName = null;
  }

  /** Returns true if field eventName is set (has been assigned a value) and false otherwise */
  public boolean isSetEventName() {
    return this.eventName != null;
  }

  public void setEventNameIsSet(boolean value) {
    if (!value) {
      this.eventName = null;
    }
  }

  public byte[] getPayload() {
    setPayload(org.apache.thrift.TBaseHelper.rightSize(payload));
    return payload == null ? null : payload.array();
  }

  public java.nio.ByteBuffer bufferForPayload() {
    return org.apache.thrift.TBaseHelper.copyBinary(payload);
  }

  public ExecuteRequestPayload setPayload(byte[] payload) {
    this.payload = payload == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(payload.clone());
    return this;
  }

  public ExecuteRequestPayload setPayload(java.nio.ByteBuffer payload) {
    this.payload = org.apache.thrift.TBaseHelper.copyBinary(payload);
    return this;
  }

  public void unsetPayload() {
    this.payload = null;
  }

  /** Returns true if field payload is set (has been assigned a value) and false otherwise */
  public boolean isSetPayload() {
    return this.payload != null;
  }

  public void setPayloadIsSet(boolean value) {
    if (!value) {
      this.payload = null;
    }
  }

  public int getInputsize() {
    return this.inputsize;
  }

  public ExecuteRequestPayload setInputsize(int inputsize) {
    this.inputsize = inputsize;
    setInputsizeIsSet(true);
    return this;
  }

  public void unsetInputsize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INPUTSIZE_ISSET_ID);
  }

  /** Returns true if field inputsize is set (has been assigned a value) and false otherwise */
  public boolean isSetInputsize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INPUTSIZE_ISSET_ID);
  }

  public void setInputsizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INPUTSIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case EVENT_NAME:
      if (value == null) {
        unsetEventName();
      } else {
        setEventName((java.lang.String)value);
      }
      break;

    case PAYLOAD:
      if (value == null) {
        unsetPayload();
      } else {
        if (value instanceof byte[]) {
          setPayload((byte[])value);
        } else {
          setPayload((java.nio.ByteBuffer)value);
        }
      }
      break;

    case INPUTSIZE:
      if (value == null) {
        unsetInputsize();
      } else {
        setInputsize((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENT_NAME:
      return getEventName();

    case PAYLOAD:
      return getPayload();

    case INPUTSIZE:
      return getInputsize();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case EVENT_NAME:
      return isSetEventName();
    case PAYLOAD:
      return isSetPayload();
    case INPUTSIZE:
      return isSetInputsize();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecuteRequestPayload)
      return this.equals((ExecuteRequestPayload)that);
    return false;
  }

  public boolean equals(ExecuteRequestPayload that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_eventName = true && this.isSetEventName();
    boolean that_present_eventName = true && that.isSetEventName();
    if (this_present_eventName || that_present_eventName) {
      if (!(this_present_eventName && that_present_eventName))
        return false;
      if (!this.eventName.equals(that.eventName))
        return false;
    }

    boolean this_present_payload = true && this.isSetPayload();
    boolean that_present_payload = true && that.isSetPayload();
    if (this_present_payload || that_present_payload) {
      if (!(this_present_payload && that_present_payload))
        return false;
      if (!this.payload.equals(that.payload))
        return false;
    }

    boolean this_present_inputsize = true;
    boolean that_present_inputsize = true;
    if (this_present_inputsize || that_present_inputsize) {
      if (!(this_present_inputsize && that_present_inputsize))
        return false;
      if (this.inputsize != that.inputsize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEventName()) ? 131071 : 524287);
    if (isSetEventName())
      hashCode = hashCode * 8191 + eventName.hashCode();

    hashCode = hashCode * 8191 + ((isSetPayload()) ? 131071 : 524287);
    if (isSetPayload())
      hashCode = hashCode * 8191 + payload.hashCode();

    hashCode = hashCode * 8191 + inputsize;

    return hashCode;
  }

  @Override
  public int compareTo(ExecuteRequestPayload other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetEventName()).compareTo(other.isSetEventName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventName, other.eventName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPayload()).compareTo(other.isSetPayload());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPayload()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.payload, other.payload);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInputsize()).compareTo(other.isSetInputsize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInputsize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inputsize, other.inputsize);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ExecuteRequestPayload(");
    boolean first = true;

    sb.append("eventName:");
    if (this.eventName == null) {
      sb.append("null");
    } else {
      sb.append(this.eventName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("payload:");
    if (this.payload == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.payload, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("inputsize:");
    sb.append(this.inputsize);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (eventName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'eventName' was not present! Struct: " + toString());
    }
    if (payload == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'payload' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'inputsize' because it's a primitive and you chose the non-beans generator.
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ExecuteRequestPayloadStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteRequestPayloadStandardScheme getScheme() {
      return new ExecuteRequestPayloadStandardScheme();
    }
  }

  private static class ExecuteRequestPayloadStandardScheme extends org.apache.thrift.scheme.StandardScheme<ExecuteRequestPayload> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ExecuteRequestPayload struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.eventName = iprot.readString();
              struct.setEventNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAYLOAD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.payload = iprot.readBinary();
              struct.setPayloadIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // INPUTSIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.inputsize = iprot.readI32();
              struct.setInputsizeIsSet(true);
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
      if (!struct.isSetInputsize()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'inputsize' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ExecuteRequestPayload struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.eventName != null) {
        oprot.writeFieldBegin(EVENT_NAME_FIELD_DESC);
        oprot.writeString(struct.eventName);
        oprot.writeFieldEnd();
      }
      if (struct.payload != null) {
        oprot.writeFieldBegin(PAYLOAD_FIELD_DESC);
        oprot.writeBinary(struct.payload);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(INPUTSIZE_FIELD_DESC);
      oprot.writeI32(struct.inputsize);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ExecuteRequestPayloadTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteRequestPayloadTupleScheme getScheme() {
      return new ExecuteRequestPayloadTupleScheme();
    }
  }

  private static class ExecuteRequestPayloadTupleScheme extends org.apache.thrift.scheme.TupleScheme<ExecuteRequestPayload> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ExecuteRequestPayload struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.eventName);
      oprot.writeBinary(struct.payload);
      oprot.writeI32(struct.inputsize);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ExecuteRequestPayload struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.eventName = iprot.readString();
      struct.setEventNameIsSet(true);
      struct.payload = iprot.readBinary();
      struct.setPayloadIsSet(true);
      struct.inputsize = iprot.readI32();
      struct.setInputsizeIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

