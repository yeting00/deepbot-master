
module slice
{
	exception GenericError {
	    string code;
	    string msg;
	};
	exception BussinessServiceException extends GenericError {};
};
