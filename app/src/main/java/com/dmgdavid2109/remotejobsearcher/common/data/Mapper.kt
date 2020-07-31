package com.dmgdavid2109.remotejobsearcher.common.data

interface Mapper<I, O> {
    fun map(input: I): O
}
