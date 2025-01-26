```
helm uninstall kubernetes-dashboard --namespace kubernetes-dashboard
kubectl -n kubernetes-dashboard create serviceaccount admin-user
kubectl -n kubernetes-dashboard create token admin-user
kubectl -n NAMESPACE create token SERVICE_ACCOUNT


docker build -t chukhnovmaksym/k8s-example-autoscaling:latest .
docker push chukhnovmaksym/k8s-example-autoscaling:latest
kubectl autoscale deployment springboot-app --cpu-percent=75 --min=1 --max=10
kubectl get hpa springboot-app -o yaml
kubectl get hpa

kubectl describe node
kubectl top pod
```


## Monitoring
#### Metrics Server
If you receive `error: Metrics API not available` after `kubectl top pod` follow the steps below:

```bash
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
kubectl patch deployment metrics-server -n kube-system --type='json' -p='[{"op": "add","path": "/spec/template/spec/hostNetwork","value": true},{"op": "replace","path": "/spec/template/spec/containers/0/args","value": ["--cert-dir=/tmp","--secure-port=4443","--kubelet-preferred-address-types=InternalIP,ExternalIP,Hostname","--kubelet-use-node-status-port","--metric-resolution=15s","--kubelet-insecure-tls"]},{"op": "replace","path": "/spec/template/spec/containers/0/ports/0/containerPort","value": 4443}]'
kubectl -n kube-system get pods -l k8s-app=metrics-server
kubectl top pod
```

> [!reference]-
> https://medium.com/@cloudspinx/fix-error-metrics-api-not-available-in-kubernetes-aa10766e1c2f

#### Kubernetes Dashboard
1) Install [Helm](https://github.com/helm/helm/releases)
2) Install [Kubernetes dashboard](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/)

##### Access to Kubernetes Dashboard
```bash
kubectl -n kubernetes-dashboard create serviceaccount admin-user
kubectl create clusterrolebinding admin-user-binding --clusterrole=cluster-admin --serviceaccount=kubernetes-dashboard:admin-user
kubectl -n kubernetes-dashboard create token admin-user
```