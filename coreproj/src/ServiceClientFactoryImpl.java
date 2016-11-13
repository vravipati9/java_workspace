
public class ServiceClientFactoryImpl implements ServiceClientFactory {

	public ExternalProxy externalProxy()
    {
        return ExternalProxyFactory.getExternalProxy();
    }

}
