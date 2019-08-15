package jdls.one.showmefoxes.framework.datasource

import jdls.one.data.repository.FoxLocalDataSource
import jdls.one.domain.model.Fox

class FoxMemoryDataSource : FoxLocalDataSource {
  override fun getSavedFoxes(): List<Fox> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun saveFox(fox: Fox) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}