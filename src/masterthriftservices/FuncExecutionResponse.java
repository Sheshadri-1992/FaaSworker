/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package masterthriftservices;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * List of functions that are called with an activation ID*
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2022-02-20")
public class FuncExecutionResponse implements org.apache.thrift.TBase<FuncExecutionResponse, FuncExecutionResponse._Fields>, java.io.Serializable, Cloneable, Comparable<FuncExecutionResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FuncExecutionResponse");

  private static final org.apache.thrift.protocol.TField RESPONSE_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("responseList", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField EXEC_RESULTS_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("execResultsList", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FuncExecutionResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FuncExecutionResponseTupleSchemeFactory();

  public java.util.List<java.lang.Integer> responseList; // required
  public java.util.List<java.lang.String> execResultsList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESPONSE_LIST((short)1, "responseList"),
    EXEC_RESULTS_LIST((short)2, "execResultsList");

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
        case 1: // RESPONSE_LIST
          return RESPONSE_LIST;
        case 2: // EXEC_RESULTS_LIST
          return EXEC_RESULTS_LIST;
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
    tmpMap.put(_Fields.RESPONSE_LIST, new org.apache.thrift.meta_data.FieldMetaData("responseList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.EXEC_RESULTS_LIST, new org.apache.thrift.meta_data.FieldMetaData("execResultsList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FuncExecutionResponse.class, metaDataMap);
  }

  public FuncExecutionResponse() {
  }

  public FuncExecutionResponse(
    java.util.List<java.lang.Integer> responseList,
    java.util.List<java.lang.String> execResultsList)
  {
    this();
    this.responseList = responseList;
    this.execResultsList = execResultsList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FuncExecutionResponse(FuncExecutionResponse other) {
    if (other.isSetResponseList()) {
      java.util.List<java.lang.Integer> __this__responseList = new java.util.ArrayList<java.lang.Integer>(other.responseList);
      this.responseList = __this__responseList;
    }
    if (other.isSetExecResultsList()) {
      java.util.List<java.lang.String> __this__execResultsList = new java.util.ArrayList<java.lang.String>(other.execResultsList);
      this.execResultsList = __this__execResultsList;
    }
  }

  public FuncExecutionResponse deepCopy() {
    return new FuncExecutionResponse(this);
  }

  @Override
  public void clear() {
    this.responseList = null;
    this.execResultsList = null;
  }

  public int getResponseListSize() {
    return (this.responseList == null) ? 0 : this.responseList.size();
  }

  public java.util.Iterator<java.lang.Integer> getResponseListIterator() {
    return (this.responseList == null) ? null : this.responseList.iterator();
  }

  public void addToResponseList(int elem) {
    if (this.responseList == null) {
      this.responseList = new java.util.ArrayList<java.lang.Integer>();
    }
    this.responseList.add(elem);
  }

  public java.util.List<java.lang.Integer> getResponseList() {
    return this.responseList;
  }

  public FuncExecutionResponse setResponseList(java.util.List<java.lang.Integer> responseList) {
    this.responseList = responseList;
    return this;
  }

  public void unsetResponseList() {
    this.responseList = null;
  }

  /** Returns true if field responseList is set (has been assigned a value) and false otherwise */
  public boolean isSetResponseList() {
    return this.responseList != null;
  }

  public void setResponseListIsSet(boolean value) {
    if (!value) {
      this.responseList = null;
    }
  }

  public int getExecResultsListSize() {
    return (this.execResultsList == null) ? 0 : this.execResultsList.size();
  }

  public java.util.Iterator<java.lang.String> getExecResultsListIterator() {
    return (this.execResultsList == null) ? null : this.execResultsList.iterator();
  }

  public void addToExecResultsList(java.lang.String elem) {
    if (this.execResultsList == null) {
      this.execResultsList = new java.util.ArrayList<java.lang.String>();
    }
    this.execResultsList.add(elem);
  }

  public java.util.List<java.lang.String> getExecResultsList() {
    return this.execResultsList;
  }

  public FuncExecutionResponse setExecResultsList(java.util.List<java.lang.String> execResultsList) {
    this.execResultsList = execResultsList;
    return this;
  }

  public void unsetExecResultsList() {
    this.execResultsList = null;
  }

  /** Returns true if field execResultsList is set (has been assigned a value) and false otherwise */
  public boolean isSetExecResultsList() {
    return this.execResultsList != null;
  }

  public void setExecResultsListIsSet(boolean value) {
    if (!value) {
      this.execResultsList = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case RESPONSE_LIST:
      if (value == null) {
        unsetResponseList();
      } else {
        setResponseList((java.util.List<java.lang.Integer>)value);
      }
      break;

    case EXEC_RESULTS_LIST:
      if (value == null) {
        unsetExecResultsList();
      } else {
        setExecResultsList((java.util.List<java.lang.String>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case RESPONSE_LIST:
      return getResponseList();

    case EXEC_RESULTS_LIST:
      return getExecResultsList();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case RESPONSE_LIST:
      return isSetResponseList();
    case EXEC_RESULTS_LIST:
      return isSetExecResultsList();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof FuncExecutionResponse)
      return this.equals((FuncExecutionResponse)that);
    return false;
  }

  public boolean equals(FuncExecutionResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_responseList = true && this.isSetResponseList();
    boolean that_present_responseList = true && that.isSetResponseList();
    if (this_present_responseList || that_present_responseList) {
      if (!(this_present_responseList && that_present_responseList))
        return false;
      if (!this.responseList.equals(that.responseList))
        return false;
    }

    boolean this_present_execResultsList = true && this.isSetExecResultsList();
    boolean that_present_execResultsList = true && that.isSetExecResultsList();
    if (this_present_execResultsList || that_present_execResultsList) {
      if (!(this_present_execResultsList && that_present_execResultsList))
        return false;
      if (!this.execResultsList.equals(that.execResultsList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetResponseList()) ? 131071 : 524287);
    if (isSetResponseList())
      hashCode = hashCode * 8191 + responseList.hashCode();

    hashCode = hashCode * 8191 + ((isSetExecResultsList()) ? 131071 : 524287);
    if (isSetExecResultsList())
      hashCode = hashCode * 8191 + execResultsList.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(FuncExecutionResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetResponseList()).compareTo(other.isSetResponseList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResponseList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.responseList, other.responseList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExecResultsList()).compareTo(other.isSetExecResultsList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExecResultsList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.execResultsList, other.execResultsList);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FuncExecutionResponse(");
    boolean first = true;

    sb.append("responseList:");
    if (this.responseList == null) {
      sb.append("null");
    } else {
      sb.append(this.responseList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("execResultsList:");
    if (this.execResultsList == null) {
      sb.append("null");
    } else {
      sb.append(this.execResultsList);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (responseList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'responseList' was not present! Struct: " + toString());
    }
    if (execResultsList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'execResultsList' was not present! Struct: " + toString());
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

  private static class FuncExecutionResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FuncExecutionResponseStandardScheme getScheme() {
      return new FuncExecutionResponseStandardScheme();
    }
  }

  private static class FuncExecutionResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<FuncExecutionResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FuncExecutionResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESPONSE_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.responseList = new java.util.ArrayList<java.lang.Integer>(_list0.size);
                int _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI32();
                  struct.responseList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setResponseListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXEC_RESULTS_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.execResultsList = new java.util.ArrayList<java.lang.String>(_list3.size);
                java.lang.String _elem4;
                for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                {
                  _elem4 = iprot.readString();
                  struct.execResultsList.add(_elem4);
                }
                iprot.readListEnd();
              }
              struct.setExecResultsListIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FuncExecutionResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.responseList != null) {
        oprot.writeFieldBegin(RESPONSE_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.responseList.size()));
          for (int _iter6 : struct.responseList)
          {
            oprot.writeI32(_iter6);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.execResultsList != null) {
        oprot.writeFieldBegin(EXEC_RESULTS_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.execResultsList.size()));
          for (java.lang.String _iter7 : struct.execResultsList)
          {
            oprot.writeString(_iter7);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FuncExecutionResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FuncExecutionResponseTupleScheme getScheme() {
      return new FuncExecutionResponseTupleScheme();
    }
  }

  private static class FuncExecutionResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<FuncExecutionResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FuncExecutionResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.responseList.size());
        for (int _iter8 : struct.responseList)
        {
          oprot.writeI32(_iter8);
        }
      }
      {
        oprot.writeI32(struct.execResultsList.size());
        for (java.lang.String _iter9 : struct.execResultsList)
        {
          oprot.writeString(_iter9);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FuncExecutionResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.responseList = new java.util.ArrayList<java.lang.Integer>(_list10.size);
        int _elem11;
        for (int _i12 = 0; _i12 < _list10.size; ++_i12)
        {
          _elem11 = iprot.readI32();
          struct.responseList.add(_elem11);
        }
      }
      struct.setResponseListIsSet(true);
      {
        org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.execResultsList = new java.util.ArrayList<java.lang.String>(_list13.size);
        java.lang.String _elem14;
        for (int _i15 = 0; _i15 < _list13.size; ++_i15)
        {
          _elem14 = iprot.readString();
          struct.execResultsList.add(_elem14);
        }
      }
      struct.setExecResultsListIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

