def call(){
  timeout(time: 1,unit: "MINUTES"){
    waitForQualityGate abortpipeline: false
  }
}
