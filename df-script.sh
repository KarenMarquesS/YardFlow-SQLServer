#!/bin/bash

# Variáveis
RESOURCE_GROUP="rg-docker-yardflow"
LOCATION="eastus2"
VM_NAME="vm-docker-yardflow"
IMAGE=almalinux:almalinux-x86_64:9-gen2:9.5.202411260
# Comando para procurar a imagem no Marketplace
# az vm image list --all -p docker -o table
#
SIZE="Standard_D2s_v3"
ADMIN_USERNAME="yardflow"
ADMIN_PASSWORD="vm-Yard@flow25"
DISK_SKU="StandardSSD_LRS"
PORT=22
SHUTDOWN_TIME="0230" ## Deve ser o UTC (Brasil está a -3 horas)

# Criar grupo de recursos
echo "Criando grupo de recursos: $RESOURCE_GROUP..."
az group create --name $RESOURCE_GROUP --location $LOCATION

# Aceitar os Termos legais da Imagem
echo "Aceitando os Termos Legais da Imagem..."
az vm image terms accept --urn dockerinc1694120899427:devbox_azuremachine:devboxlicensefpromo:4.38.0

# Criar a VM
echo "Criando a máquina virtual: $VM_NAME..."
az vm create \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --image $IMAGE \
  --size $SIZE \
  --authentication-type password \
  --admin-username $ADMIN_USERNAME \
  --admin-password $ADMIN_PASSWORD \
  --storage-sku $DISK_SKU \
  --public-ip-sku Basic

# Abrir a porta ssh
echo "Abrindo porta $PORT para ssh..."
az vm open-port --port $PORT --resource-group $RESOURCE_GROUP --name $VM_NAME

# Ativar desligamento automático
echo "Configurando desligamento automático às $SHUTDOWN_TIME (UTC)..."
az vm auto-shutdown \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --time $SHUTDOWN_TIME

echo "✅   Provisionamento completo!"
