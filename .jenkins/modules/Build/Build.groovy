/**
 * Common build module
 */

MPLModule('Build', CFG)
echo "Step-1"

if( fileExists('Dockerfile') ) {
  MPLModule('Docker Build', CFG)
}
