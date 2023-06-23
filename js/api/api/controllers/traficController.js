const trafic = require("../models/trafic")
class traficController {

    fetchAll(req,res){
        trafic.find({}).
            then(trafics => {              
                return res.end(JSON.stringify(trafics));
            }).
            then(customers => {
                console.log(JSON.stringify(trafics)); // 'B'
            });
    }
    add(req,res){
        
        trafic.create({flightId:req.param('flightId'),progress:req.param('progress'),completed:req.param('completed')})
        return res.json("trafic added!")
    }

    updatePeriodic(){
        //trafic.updateMany({}, { $inc: { progress: 5 } })
        console.log("hello ahmed!")
    }
}

module.exports = traficController