/**
 * Common build module
 */

MPLModule('Build', CFG)
echo "Step1"

if( fileExists('Dockerfile') ) {
  echo "step2"
  MPLModule('Docker Build', CFG)
}
