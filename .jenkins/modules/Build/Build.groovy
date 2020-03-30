/**
 * Common build module
 */

MPLModule('Test Build', CFG)
echo "Step-1"

if( fileExists('Dockerfile') ) {
  MPLModule('Docker Build', CFG)
}
