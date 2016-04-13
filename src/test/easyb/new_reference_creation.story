import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*


description """An user can add a new reference"""

scenario "creation succesfull with valid values", {
    given 'command submit selected', {
       ref=new ReferenceController()
re = new Reference("Testaaja2", "Artikkeli2")
bind = new BindingResult()


    }
 
    when 'a valid values are entered', {
   ref.create(re,bind)
    }

    then 'new reference is registered to system', {
      List<Reference>lista=ref.findAll()
List.contains("Testaaja2")
    }
}


scenario "creation fails with invalid values", {
    given 'command add new reference is selected'
    when 'invalid values are entered'
    then 'new reference is not added to system'
}

