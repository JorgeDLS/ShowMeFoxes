package jdls.one.showmefoxes.framework.datasource

import jdls.one.domain.model.Fox

data class FoxEntity(val image: String, val link: String) {

  fun mapToDomain(): Fox = Fox(image, link)

}
