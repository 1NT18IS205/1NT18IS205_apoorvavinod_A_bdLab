const mongoose = require('mongoose');

const PostSchema = new mongoose.Schema({
    name: String,
    email: String, 
    upvotes: { type: Number, default: 0 },
    comments: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Comment' }]
});

mongoose.model('Post', PostSchema);