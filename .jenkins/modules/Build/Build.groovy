/**
 * Common build module
 */

if( fileExists('Dockerfile') ) {
  MPLModule('Docker Build', CFG)
  echo "test build groovy"
}
