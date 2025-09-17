package com.wayads.backend_api.infrastructure.exceptions

class ResourceNotFoundException(resource: String, id: Any) :
    RuntimeException("$resource with id=$id not found")