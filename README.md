# K8s autoscaling demo
This project was created to practice Kubernetes autoscaling using (HPA) and other basic K8s features.
Core part is Spring Boot app which handles CRUD op. for Users management. The password decode operation, which is a CPU intensive task, was chosen for load testing.

## Installation & Deletion
```bash
kubectl apply -f .\k8s\prod\ -n autoscaling
```
```bash
kubectl delete -f .\k8s\prod\ --recursive
```






