module.exports = function (grunt) {
    var srcPaths = [
        'src/**/*.js'
    ];

    grunt.initConfig({
        concat: {
            zh: {
                options: {
                    process: function (src, filepath) {
                        return '// FILE: ' + filepath + '\n' + src + '\n';
                    }
                },
                src: srcPaths,
                dest: 'dist/main.js'
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');

    grunt.registerTask('default', ['concat']);

};