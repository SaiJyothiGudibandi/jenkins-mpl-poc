/**
 * Common deploy module
 */

if( fileExists('Dockerfile') ) {
    MPLModule('Docker Deploy', CFG)
    echo "test deploy groovy"
}

