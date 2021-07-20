const mongoose = require("mongoose")
mongoose.connect('mongodb://localhost/Travl',{
    useNewUrlParser:true,
    useUnifiedTopology:true,
    useCreateIndex:true
}).then(() => {
    console.log(`connection successful`);
}).catch((e)=>{
    console.log(`no connection`);
});

const schema = mongoose.Employee;