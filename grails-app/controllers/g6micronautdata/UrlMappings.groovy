package g6micronautdata

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/" controller: 'person'
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
