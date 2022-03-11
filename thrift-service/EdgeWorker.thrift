#namespace py thriftservices
namespace java thriftservices
#namespace java iisc.csl.faas.thrift

typedef i32 int32

struct Argument {
	1: required string argName;
	2: required binary argPayload;
}

struct Specification {
	1: required double vCPUs;
	2: required double RAM;
}

struct PutBlockResponse {
	1: required i32 status;
	2: optional string response;
}

struct InvokeFunctionResponse {
	1: required i32 status;
	2: optional string response;
}

struct Location {
	1: required string IP;
	2: required i32 port;
}

struct GetBlockResponse {
	1: required list<Argument> paramList;
	2: optional string response;
}

struct WriteResultResponse {
	1: required i32 status;
	2: optional string response;
}

struct ImageBinary {
	1: required binary imageFile;
	2: required i32 fileLength;
}

service WorkerService {
	PutBlockResponse putBlock(1: string event_function_id, 2: list<Argument> parameterArray);
	InvokeFunctionResponse invokeFunction(1: string functionName, 2: Specification specs, 3: Location paramLocation, 4: string paramFileName);
	GetBlockResponse getBlock(1: string filename, 2: Location dataLocation);
	WriteResultResponse writeResultsToMaster(1: string functionName, 2: string eventID, 3: string directoryName, 4: i32 dataNodeID);
	string readFileFromWorker(1: string directoryName, 2: Location workerLocation);	
	string writeFileToWorker(1: string directoryName,2: list<ImageBinary> imageBinaryList, 3: Location workerLocation);

	string testmethod(1: string test);
	string testinputsize(1: binary inputsize);
}
