//
//  MainViewModel.swift
//  ShepherdProduct
//
//  Created by k4keye on 2022/03/09.
//

import Foundation


class MainViewModel : ObservableObject{
    @Published var result : String = ""
    
    func search(searchText:String, searchType:SearchType){
        getApiUrl(searchText: searchText, searchType: searchType)
    }
    
    private func getApiUrl(searchText:String, searchType:SearchType){
        // case Product, Company
       
        let baseUrl = "http://apis.data.go.kr/1471000/FoodFlshdErtsInfoService02/getFoodFlshdErtsList?"
        
        let serviceKey : String = "ServiceKey="+"ecRUAWQCCIj7fved9BSoyYhkCrLWpUswHZ6bq5I635bB0GG76X5Mc4Wv11MWAfPz3B01eprG1KmgWX46Qlw3oA=="
        let pageNo : String = "pageNo="+"1"
        let type : String = "type="+"json"
        let searchText : String = searchType == SearchType.Company ? "Entrps="+searchText : "Prduct="+searchText
        
        let url = "\(baseUrl)\(serviceKey)&\(pageNo)&\(type)&\(searchText)"
        
        print("create URL : \(url)")
        
        guard let url = URL(string: url)else{
            return
        }
        
        let task = URLSession.shared.dataTask(with: url){ data, _, error in
            guard let data = data, error == nil else {
                return
            }
            do{
                print("api data : \(data)")
                guard let model = try? JSONDecoder().decode(SearchEntity.self, from: data) else{
                    print("api decode faild")
                    return
                }
                print("api data : \(model)")
            }
            catch{
                print("api faild")
            }

        }
        task.resume()
        
    }
    
    func testClick(){
        print("hello world")
    }
    
}
