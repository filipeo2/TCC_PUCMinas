using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceProcess;
using System.Text;
using System.Threading.Tasks;

namespace CovidServiceHost
{
    class CovidWindowsService : ServiceBase
    {
        public ServiceHost serviceHost = null;
        public CovidWindowsService()
        {
            ServiceName = "WCFCovidService";
        }
        public static void Main()
        {
            ServiceBase.Run(new CovidWindowsService());
        }

        // Start the Windows service.
        protected override void OnStart(string[] args)
        {
            if (serviceHost != null)
            {
                serviceHost.Close();
            }

            serviceHost = new ServiceHost(typeof(CovidWcf.CovidService));

            serviceHost.Open();
        }
        protected override void OnStop()
        {
            if (serviceHost != null)
            {
                serviceHost.Close();
                serviceHost = null;
            }
        }
    }
}
