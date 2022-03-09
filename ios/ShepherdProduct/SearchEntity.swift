//
//  SearchEntity.swift
//  ShepherdProduct
//
//  Created by k4keye on 2022/03/09.
//

import Foundation

struct SearchEntity: Codable{
    let header : Header
    let body : Body
    
}

struct Header : Codable{
    let resultCode: String
    let resultMsg: String
}

struct Body : Codable{
    let pageNo: Int
    let totalCount: Int
    let numOfRows: Int
    let items: [Item]
}

struct Item : Codable{
    let ENTRPS: String
    let PRDUCT: String
    let DSPS_DT: String?
}


struct SearchResult {
    var code: Bool
    let items: [Item]?
}
