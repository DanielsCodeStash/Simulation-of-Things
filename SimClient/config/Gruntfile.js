var js_files = ['../modules/**/*.js'];
var css_files = ['../modules/**/*.css'];
var template_files = ['../modules/**/*.hbs', '../modules/**/html/*.hbs'];

var index_file_name = "index.html";
var index_file_path = "../" + index_file_name;

var init_file_name = "init.js";
var init_file_path = "../" + init_file_name;

var js_lib_files = ['lib/*.js', 'lib/**/*.js', 'lib/**/**/*.js'];
var html_files = ['../modules/**/*.html'];
var img_files = ['../modules/**/*.png'];
var hbs_files = ['../modules/**/*.hbs'];
var res_files = img_files.concat(html_files);



var watched_files = js_files.concat(css_files)
    .concat(template_files)
    .concat(html_files)
    .concat(hbs_files)
    .concat(index_file_path)
    .concat(init_file_path);

var out_folder = "../out";
var dev_out_folder = '../out/dev';
var prod_out_folder = '../out/prod';

var app_file = "app.js";
var app_min_file = "app.min.js";

var app_css_file = "app.css";
var app_css_min_file = "app.min.css";

var template_file = "template.js";

var require_file = "require_load.js";
var require_min_file = "require_load.min.js";



module.exports = function(grunt) {

    grunt.initConfig({

        pkg: grunt.file.readJSON('package.json'),


        concat: {
            js_dev: {
                options: {
                    sourceMap: true,
                    separator: ';'
                },
                dest: dev_out_folder + "/" + app_file,
                src: js_files
            },
            css_dev: {
                options: {
                    sourceMap: true
                },
                dest: dev_out_folder + "/" + app_css_file,
                src: css_files
            },
            js_prod: {
                options: {
                    sourceMap: false,
                    separator: ';'
                },
                dest: prod_out_folder + "/" + app_file,
                src: js_files
            },
            css_prod: {
                options: {
                    sourceMap: false,
                    separator: ';'
                },
                dest: prod_out_folder + "/" + app_css_file,
                src: css_files
            }
        },

        watch: {
            dev: {
                files: watched_files,
                tasks: ['dev_fast_rebuild'],
                options: {
                    spawn: false,
                    livereload: true
                }
            },
            prod: {
                files: watched_files,
                tasks: ['prod'],
                options: {
                    spawn: false,
                    livereload: true
                }
            }
        },


        dev_out_require_file: dev_out_folder + "/" + require_file,
        prod_out_require_file: prod_out_folder + "/" + require_file,
        browserify: {
            dev: {
                files: {
                    '<%= dev_out_require_file %>': require_file
                },
                options: {
                    browserifyOptions: {
                        debug: true
                    }
                }
            },
            prod: {
                files: {
                    '<%= prod_out_require_file %>': require_file
                },
                options: {
                    browserifyOptions: {
                        debug: false
                    }
                }
            }
        },

        jshint: {
            beforeconcat: js_files,
            afterconcat: [dev_out_folder + "/" + app_file, prod_out_folder + "/" + app_file]
        },


        jsbeautifier: {
            files: js_files.concat(['Gruntfile.js']).concat(init_file_path)
        },


        clean: {
            options: {
                force: true
            },
            all: {
                src: [out_folder] + "/**/**/**/**/**/**/*.*"
            },
            dev: {
                src: [dev_out_folder] + "/**/**/**/**/**/**/*.*"
            },
            prod: {
                src: [prod_out_folder] + "/**/**/**/**/**/**/*.*"
            },
            prod_non_mini: {
                src: [
                    prod_out_folder + "/" + app_file,
                    prod_out_folder + "/" + require_file,
                    prod_out_folder + "/" + app_css_file
                ]
            }
        },

        connect: {
            dev: {
                options: {
                    port: 9001,
                    base: dev_out_folder
                },
                livereload: true
            },
            prod: {
                options: {
                    port: 9002,
                    base: prod_out_folder
                },
                livereload: true
            }
        },


        open: {
            dev: {
                path: 'localhost:9001',
                app: 'Chrome'
            },
            prod: {
                path: 'localhost:9002',
                app: 'Firefox'
            }

        },

        prod_min_require_file: prod_out_folder + "/" + require_min_file,
        prod_min_app_file: prod_out_folder + "/" + app_min_file,
        uglify: {
            prod: {
                files: {
                    '<%= prod_min_require_file %>': [prod_out_folder + "/" + require_file],
                    '<%= prod_min_app_file %>': [prod_out_folder + "/" + app_file]
                }
            }
        },

        env: {
            dev: {
                NODE_ENV: 'DEVELOPMENT'
            },
            prod: {
                NODE_ENV: 'PRODUCTION'
            }
        },

        preprocess: {
            dev: {
                src: index_file_path,
                dest: dev_out_folder + '/' + index_file_name
            },
            prod: {
                src: index_file_path,
                dest: prod_out_folder + '/' + index_file_name
            }
        },

        cssmin: {
            prod: {
                files: [{
                    src: prod_out_folder + "/" + app_css_file,
                    dest: prod_out_folder + "/" + app_css_min_file
                }]
            }
        },

        dev_tmpl_file: dev_out_folder + "/" + template_file,
        prod_tmpl_file: prod_out_folder + "/" + template_file,
        jst: {
            dev: {
                options: {
                    prettify: true
                },
                files: {
                    '<%= dev_tmpl_file %>': template_files
                }
            },
            prod: {
                files: {
                    '<%= prod_tmpl_file %>': template_files
                }
            }
        },

        handlebars: {
            dev: {
                files: {
                    '<%= dev_tmpl_file %>': template_files
                }
            },
            prod: {
                files: {
                    '<%= prod_tmpl_file %>': template_files
                }
            }
        },

        copy: {
            dev: {
                files: [{
                    src: js_lib_files,
                    dest: dev_out_folder + "/",
                    expand: true
                }, {
                    src: res_files,
                    dest: dev_out_folder + "/dev/",
                    expand: true
                }, {
                    src: init_file_path,
                    dest: dev_out_folder + "/dev/",
                }]
            },
            rebuild: {
                files: [{
                    src: res_files,
                    dest: dev_out_folder + "/dev/",
                    expand: true
                }, {
                    src: init_file_path,
                    dest: dev_out_folder + "/dev/",
                }]
            }
        }

    });

    // load
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-browserify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-jsbeautifier');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-open');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-env');
    grunt.loadNpmTasks('grunt-preprocess');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-handlebars');
    grunt.loadNpmTasks('grunt-contrib-copy');

    // register
    grunt.registerTask('default', ['debug']);
    grunt.registerTask('debug', ['dev', 'connect:dev', 'open:dev', 'watch:dev']);
    grunt.registerTask('run_prod', ['prod', 'connect:prod', 'open:prod', 'watch:prod']);

    grunt.registerTask('dev_fast_rebuild', ['env:dev', 'preprocess:dev', 'copy:rebuild', 'jshint:beforeconcat', 'concat:js_dev', 'concat:css_dev', 'handlebars:dev']);
    grunt.registerTask('dev', ['clean:dev', 'env:dev', 'preprocess:dev', 'copy:dev', 'jshint:beforeconcat', 'concat:js_dev', 'concat:css_dev', 'handlebars:dev', 'browserify:dev', 'jsbeautifier']);
    grunt.registerTask('prod', ['clean:prod', 'env:prod', 'preprocess:prod', 'copy:dev', 'concat:js_prod', 'concat:css_prod', 'handlebars:prod', 'browserify:prod', 'jsbeautifier', 'uglify:prod', 'cssmin:prod', 'clean:prod_non_mini'])
};
