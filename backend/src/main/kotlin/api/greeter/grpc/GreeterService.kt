package app.grpc

import api.greeter.grpc.GreeterGrpc
import api.greeter.grpc.GreeterOuterClass
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService


@GRpcService
class GreeterService : GreeterGrpc.GreeterImplBase() {
    override fun hello(request: GreeterOuterClass.HelloRequest, responseObserver: StreamObserver<GreeterOuterClass.HelloResponse>) {
        val replyBuilder = GreeterOuterClass.HelloResponse.newBuilder().setGreeting("Hello " + request!!.name)
        responseObserver.onNext(replyBuilder.build())
        responseObserver.onCompleted()
    }
}